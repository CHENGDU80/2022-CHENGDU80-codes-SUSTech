import pandas as pd
import pickle
import lightgbm as lgb
import sys
# X_test = pd.read_csv("E:\javaproject\chengdu80\src\main\java\cn\edu\sustech\zxc\\booking\java2py\example.csv")
X_test = pd.read_csv(sys.argv[1])
loaded_model = pickle.load(open("E:\javaproject\chengdu80\src\main\java\cn\edu\sustech\zxc\\booking\java2py\clf_lgb.pkl", "rb"))
y_pred = loaded_model.predict(X_test)
print(y_pred)