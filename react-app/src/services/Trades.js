import axios from "axios";
import Cookies from "js-cookie";

const url = "https://bondtracker.up.railway.app/api";

export const getAllTradesOfUser = async () => {
  const endpoint = "/trade/getTradeByUserID";
  const accessToken = Cookies.get("accessToken");
  try {
    const response = await axios.get(url + endpoint, {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${accessToken}`,
      },
    });
    return response.data;
  } catch (error) {
    console.log(error);
  }
};

export const getTradeByIdOfUser = async (id) => {
  const endpoint = `/trade/${id}`;
  const accessToken = Cookies.get("accessToken");
  try {
    const response = await axios.get(url + endpoint, {
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${accessToken}`,
      },
    });
    return response.data;
  } catch (error) {
    console.log(error);
  }
};
