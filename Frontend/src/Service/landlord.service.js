import axios from "axios";

const app=axios.create({
    baseURL:'http://localhost:8080/lanlord',
    headers:{
        'Content-Type':'application/json'
    }
});

const getLandlord =(landlordId)=>{
    return app.get("/"+landlordId)
}