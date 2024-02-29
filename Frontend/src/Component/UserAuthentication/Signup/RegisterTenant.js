import { createTheme } from '@mui/material';
import React from 'react'
import { useNavigate } from 'react-router-dom';
import registerService from '../../../Service/login.service';
import { useState } from 'react';

function RegisterTenant() {
    const defaultTheme = createTheme();
    const [loading, setLoading] = React.useState(true);
    const navigate = useNavigate();
    const initialValues = { firstName: "", lastName: "", emailId: "", password: "", phone: "" };
    const [formValues, setFormValues] = useState(initialValues);
    const [formErrors, setFormErrors] = useState({});
    const [isFormValid, setIsFormValid] = useState(false);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
        validateField(name, value);
    };

    const validateField = (fieldName, value) => {
        let errors = { ...formErrors };
        switch(fieldName) {
            case 'firstName':
            case 'lastName':
                errors[fieldName] = value.trim() === '' ? `${fieldName} is required` : '';
                break;
            case 'emailId':
                errors[fieldName] = !/\S+@\S+\.\S+/.test(value) ? 'Invalid email address' : '';
                break;
            case 'password':
                errors[fieldName] = value.length < 6 ? 'Password must be at least 6 characters long' : 
                !/\d/.test(value) || !/[a-zA-Z]/.test(value) ? 'Password must contain both letters and numbers' : '';
                break;
            case 'phone':
                errors[fieldName] = !/^\d{10}$/.test(value) ? 'Phone number must be 10 digits' : '';
                break;
            default:
                break;
        }
        setFormErrors(errors);
    };

    const handleSubmit = async(e) => {
        e.preventDefault();
        const noErrors = Object.values(formErrors).every(error => error === '');
        if (noErrors) {
            try {
                await registerService.registerTenant(formValues);
                setFormValues(initialValues);
                setFormErrors({});
                navigate("/login/tenant");
                console.log("Form submitted:", formValues);
            } catch (error) {
                console.error("Error Registering",error);
            }        
        } else {
            console.log("Form has errors. Cannot submit.");
        }
    };

    React.useEffect(() => {
        setIsFormValid(Object.values(formErrors).every(error => error === '') &&
                       Object.values(formValues).every(value => value !== ''));
    }, [formErrors, formValues]);

    return (
        <div className="cont">
           
            <div className="row justify-content-center">
                <div className="col-md-4">
                    <div className="card">
                      
                        <div className="card-body">
                            <form onSubmit={handleSubmit}>
                                <h2 className="mb-4">Tenant Form</h2>
                                <div className="mb-3">
                                    <input type="text" name="firstName" className="form-control" placeholder="Firstname" value={formValues.firstname} onChange={handleChange} />
                                    {formErrors.firstName && <p className="error">{formErrors.firstName}</p>}
                                </div>
                                <div className="mb-3">
                                    <input type="text" name="lastName" className="form-control" placeholder="Lastname" value={formValues.lastname} onChange={handleChange} />
                                    {formErrors.lastName && <p className="error">{formErrors.lastName}</p>}
                                </div>
                                <div className="mb-3">
                                    <input type="text" name="emailId" className="form-control" placeholder="Email" value={formValues.email} onChange={handleChange} />
                                    {formErrors.emailId && <p className="error">{formErrors.emailId}</p>}
                                </div>
                                <div className="mb-3">
                                    <input type="password" name="password" className="form-control" placeholder="Password" value={formValues.password} onChange={handleChange} />
                                    {formErrors.password && <p className="error">{formErrors.password}</p>}
                                </div>
                                <div className="mb-3">
                                    <input type="text" name="phone" className="form-control" placeholder="Phone" value={formValues.phone} onChange={handleChange} />
                                    {formErrors.phone && <p className="error">{formErrors.phone}</p>}
                                </div>
                                <button type="submit" className="btn btn-primary" disabled={!isFormValid}> Save and Continue </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    );
}

export default RegisterTenant;
