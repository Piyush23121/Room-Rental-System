import axios from "axios";

const app=axios.create({
    baseURL:'http://localhost:8080/',
    headers:{
        'Content-Type':'application/json'
    }
});

const getcity=()=>{
    return app.get(`/property/city`);
}
const getarea=()=>{
    return app.get('/property/area');
}
const ownerproperties =(id)=>{
    return app.post(`/property/owner/${id}`);
}

export default getarea;
