import axios from 'axios';

const axiosClient = axios.create({
    baseURL: 'http://localhost:8080/api',  // Backend base URL
});

// Add a request interceptor to attach token
axiosClient.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem('token');
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

export default axiosClient;
