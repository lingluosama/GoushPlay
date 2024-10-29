import type {AxiosRequestConfig} from 'axios';
import axios from "axios";
export const  httpInstance =axios.create({})

httpInstance.defaults.baseURL="http://localhost:8342";
httpInstance.interceptors.request.use(config => {
    return config
}, err => {
    console.log(err);
})
export const $http = async (config: AxiosRequestConfig) => {
    const loadingInstance = ElLoading.service();
    httpInstance.defaults.withCredentials = true;
    
    try {
        const axiosResponse = await httpInstance(config);
        if (axiosResponse.data.code !== 1) {
        }
        return axiosResponse.data;
    } catch (err) {
            console.log(err);
    } finally {
        loadingInstance.close();
    }

}
