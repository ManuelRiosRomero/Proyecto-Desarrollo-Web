export function LoginServices() {
  async function login(body) {
    const url = "http://68.235.48.124:1001/users/login";
    const config = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: body,
    };

    const response = await fetch(url, config);

    if (!response.ok) {
      throw new Error(response.statusText);
      //throw new Error(response.statusText);
    }

    return await response.json();
  }
  return {
    login,
  };
}
