import { createRouter, createWebHistory } from 'vue-router';


const Login = () =>import( './pages/Login.vue');
const Signup = () => import('./pages/Signup.vue');
const Home = () =>import( './pages/Home.vue');
const Cart = () =>import( './pages/Cart.vue');

const routes = [
    { path: '/login', component: Login },
    { path: '/signup', component: Signup },
    { path: '/Home', component: Home },
    { path: '/Cart', component: Cart },

];

const router = createRouter({
    history: createWebHistory(),
    routes,
});


export default router;