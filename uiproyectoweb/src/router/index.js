import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/HomeView.vue";
import About from "../views/AboutView.vue";
import Pedido from "../views/pedido/Pedido.vue";
import Menu from "../views/menu/Menu.vue";
import CrearPlato from "../views/menu/CrearPlato.vue";
import Login from "../views/LoginView.vue";
import Factura from "../views/pedido/factura/Factura.vue";
import CrearFactura from "../views/pedido/factura/CrearFactura.vue";

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
    component: Pedido,
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
  {
    path: "/factura",
    component: Factura,
  },
  {
    path: "/factura/create",
    component: CrearFactura,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
