import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/HomeView.vue";
import About from "../views/AboutView.vue";
import Pedido from "../views/pedido/Pedido.vue";
import Menu from "../views/menu/Menu.vue";

const routes = [
  {
    path: "/test",
    component: Home,
  },
  {
    path: "/about",
    component: About,
  },
  {
    path: "/pedido",
    component: Pedido,
    //props: true,
  },
  {
    path: "/menu",
    component: Menu,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
