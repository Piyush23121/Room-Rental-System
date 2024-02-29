import axios from "axios";

const app=axios.create({
    baseURL:'http://localhost:8080/',
    headers:{
        'Content-Type':'application/json'
    }
});

const loginLandlord = (credentials)=>{
    return app.post("/landlord/login",credentials);
}
const loginTenant = (credentials)=>{
    return app.post("/tenant/login",credentials);
}
const registerLandlord = (userData)=>{
    return app.post("/landlord/add",userData);
}
const registerTenant = (useData)=>{
    return app.post("/tenant/add",useData);
}
const exportModule = {loginLandlord,loginTenant,registerLandlord,registerTenant}
export default exportModule;