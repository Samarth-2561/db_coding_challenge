import axios from "axios";

const url = "https://bondtracker.up.railway.app/api";

export const fetchSecurites = async() => {
    const res = await axios.get(url + `/security/all`);
    return res.data;
}

export const fetchSecuritesById = async(id) => {
    const res = await axios.get(`${url}/security/id/${id}`);
    return res.data;
}

// export const createSecurity = (newSecurity) => {
//     axios.post(url, newSecurity);
// }

// export const updateSecurity = (id, updatedSecurity) => {
//     axios.patch(`${url}/${id}`, updatedSecurity);
// }

// export const deleteSecurity = (id) => {
//     axios.delete(`${url}/${id}`);
// }