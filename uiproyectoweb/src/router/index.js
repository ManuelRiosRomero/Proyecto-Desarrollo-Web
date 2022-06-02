import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/HomeView.vue";
import About from "../views/AboutView.vue";
import Menu from "../views/menu/Menu.vue";
import CrearPlato from "../views/menu/CrearPlato.vue";
import Login from "../views/LoginView.vue";
import AgregarPlatosPedido from "@/views/pedido/AgregarPlatosPedido";

const routes = [
  {
    path: "/",
    component: Home,
  },
  {
    path: "/about",
    component: About,
  },
  {
    path: "/pedido",
    component: AgregarPlatosPedido,
    //props: true,
  },
  {
    path: "/menu",
    component: Menu,
  },
  {
    path: "/menu/crearplato",
    component: CrearPlato,
  },
  {
    path: "/login",
    component: Login,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
