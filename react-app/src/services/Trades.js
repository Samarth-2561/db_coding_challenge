import axios from "axios";

const url = "https://bondtracker.up.railway.app/api";

export const fetchTrades = async() => {
    const res = await axios.get(url + `/trade`);
    return res.data;
}

export const fetchTradesById = async(id) => {
    const res = await axios.get(`${url}/trade/${id}`);
    return res.data;
}

// export const fetchTradesBySecurity = (securityId) => {
//     axios.get(`${url}/${securityId}`);
// }

// export const createTrade = (newTrade) => {
//     axios.post(url, newTrade);
// }

// export const updateTrade = (id, updatedTrade) => {
//     axios.patch(`${url}/${id}`, updatedTrade);
// }