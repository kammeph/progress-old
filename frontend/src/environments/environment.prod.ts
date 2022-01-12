let win = (window as { [key: string]: any });

export const environment = {
  production: true,
  apiUrl: win["env"]["apiUrl"]
};
