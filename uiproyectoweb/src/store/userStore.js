import { readonly, ref } from "vue";

const emptyUser = {
  //id: "",
  //name: "",
  email: "",
};

const user = ref(emptyUser);

export function userStore() {
  function updateUser(newUser) {
    user.value = newUser;
  }

  function logout() {
    user.value = emptyUser;
  }
  return {
    user: readonly(user),
    updateUser,
    logout,
  };
}
