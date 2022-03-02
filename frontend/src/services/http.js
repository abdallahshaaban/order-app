import axios from 'axios'


const REQUEST = axios.create({
    baseURL: 'http://localhost:9000/',
    headers: {
        'Content-Type': 'application/json'
    },
})

export default {
    post(url, data) {
        // if (Vue.prototype.$user && Vue.prototype.$user.getSAMLart()) {
        //     REQUEST.defaults.headers['X-Auth-Token'] = Vue.prototype.$user.getSAMLart()
        // }
        let token = JSON.parse( localStorage.getItem('token') );
        REQUEST.defaults.headers['Authorization'] = token;
        let promise = REQUEST.post(url, data, {
            transformResponse: [
                function (response) {
                    if (response.data) return JSON.parse(response.data)
                    return JSON.parse(response)
                },
            ],
        });
        return promise;
    },
    get(url) {
        let token = JSON.parse( localStorage.getItem('token') );
        REQUEST.defaults.headers['Authorization'] = token;
        let promise = REQUEST.get(url, {
            transformResponse: [
                function (response) {
                    if (response.data) return JSON.parse(response.data)
                    return JSON.parse(response)
                },
            ],
        });
        return promise;
    },
}