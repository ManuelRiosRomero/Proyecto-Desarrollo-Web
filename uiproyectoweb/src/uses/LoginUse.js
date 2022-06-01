import { computed, ref } from "vue";
import { LoginServices } from "../services/authenticate/loginServices";
import { userStore } from "@/store/userStore";
import { useRouter } from "vue-router";

export function LoginUse() {
  const { login } = LoginServices();
  const { updateUser } = userStore();
  const router = useRouter();
  const formLogin = ref({
    email: "",
    password: "",
  });

  async function authenticate() {
    const infoUser = await login(JSON.stringify(formLogin.value));
    const user = {
      email: infoUser.email,
    };
    updateUser(user);
    await router.push("/test");
    console.log(infoUser);
  }

  const enableButton = computed(() => {
    return !(
      formLogin.value.email.length > 0 && formLogin.value.password.length > 0
    );
  });

  return {
    formLogin,
    authenticate,
    enableButton,
    login,
    updateUser,
  };
}
