import axios from "axios";
import Cookies from "js-cookie";

const url = "https://bondtracker.up.railway.app/api";

export const fetchSecurites = async () => {
  const accessToken = Cookies.get("accessToken");
  try {
    const response = await axios.get(url + '/security', {
      headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${accessToken}`,
      },
    });
    console.log(response.data);
    return response.data;
  } catch (error) {
    console.log(error);
  }
};

export const fetchSecuritesById = async (id) => {
    const accessToken = Cookies.get("accessToken");
    try {
        const response = await axios.get(url + `/security/${id}`, {
          headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${accessToken}`,
          },
        });
        console.log(response.data);
        return response.data;
      } catch (error) {
        console.log(error);
      }
};
