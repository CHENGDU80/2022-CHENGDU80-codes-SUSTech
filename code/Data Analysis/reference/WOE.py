# %%
import pandas as pd
import numpy as np
from sklearn import preprocessing
from collections import OrderedDict
import warnings; warnings.filterwarnings("ignore")

# %%
X_train = pd.read_csv("data/train/feature.csv")
y_train = pd.read_csv("data/train/label.csv")
X_test  = pd.read_csv("data/test/feature.csv")
y_test  = pd.read_csv("data/test/label.csv")
print(X_train.shape)
print(y_train.shape)
print(X_test.shape)
print(y_test.shape)

# %%
v_names = X_train.columns[1:]
df_train = pd.merge(X_train, y_train, on= 'APPLICATION_ID')
df_train.head()

# %%
# 如果是连续性数据，首先排序分为5组，离散化之后，计算WOE
# 如果是离散型数据，直接分类就好（0-10等）, 计算WOE
label = "DEFAULT_LABEL"
n_bins =  5
B_total = df_train[label].sum()           # default, y = 1
G_total = len(df_train[label]) - B_total  # not default, y = 0
WOE_list = []
for v_name in v_names:
    data_type = 'discrete'
    df_v = df_train[[v_name, label]]
    df_v.dropna(inplace = True)

    if len(df_v[v_name].unique()) > 50:
        # continuous 离散化
        # https://scikit-learn.org/stable/modules/preprocessing.html#discretization
        data_type = 'continous'
        data = preprocessing.KBinsDiscretizer(n_bins=n_bins, encode='ordinal', strategy='quantile').fit_transform(df_v[[v_name]])
        df_v[v_name] = data  # 离散化
    df_data = pd.pivot_table(df_v, index = v_name,columns=label, values=label, aggfunc=len, fill_value=0)
    df_data[0] = df_data[0] / G_total   # good y=0
    df_data[1] = df_data[1] / B_total   # bad  y=1
    ratio = np.log(df_data[0] / df_data[1])
    ratio.replace([np.inf, -np.inf], 0, inplace=True)
    # save
    tmp_dict = OrderedDict()
    tmp_dict["name"] = v_name
    tmp_dict["WOE"] = ratio.sum()
    tmp_dict['Type'] = data_type
    WOE_list.append(tmp_dict)

WOE_result = pd.DataFrame(WOE_list)
WOE_result.head()


# %%
WOE_result

# %% [markdown]
# 

# %%



