import request from '../utils/request';

// const target = "http://127.0.0.1:9999/"
// const target = "http://localhost:9999/"
const target = "http://18.167.62.68:9999/"
export const fetchData = () => {
    return request({
        url: './table.json',
        method: 'get'
    });
};

export const getDataPreview = () => {
    return request({
        url: './datapreview.json',
        method: 'get'
    });
};

export const getDataSelect = () => {
    return request({
        url: './dataSelect.json',
        method: 'get'
    });
};

export const getAdmin = () => {
    return request({
        url: target+'api/v1/admin/admin',
        method: 'get'
    });
};

export const addAdmin = () => {
    return request({
        url: target+'api/v1/admin/admin',
        method: 'post',
        data:{
            "username": "0000"
        }
    });
};


export const getLogs = () => {
    return request({
        url: target+'log/all',
        method: 'get'
    });
};

export const getLog = (val:string) => {
    return request({
        url: target+'log/log',
        
        method: 'post',
        data:{
            "type": val
        }
    });
};

