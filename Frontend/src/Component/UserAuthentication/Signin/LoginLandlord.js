import React from 'react'
import { useNavigate } from "react-router-dom";
import loginService from '../../../Service/login.service';
import Alert from "@mui/material/Alert";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import { Link as MuLink } from "@mui/material";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
// import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { createTheme, ThemeProvider } from "@mui/material/styles";

function LoginLandlord() {
    const [validCreds, setValidCreds] = React.useState(true);
    const defaultTheme = createTheme();
    const navigate = useNavigate();
    React.useEffect(() => {
        // async function storedCreds() {
        //     const userId = localStorage.getItem('ownerId') || sessionStorage.getItem("ownerId");
        // }
    })
    const userLogin = async (e) => {
        e.preventDefault();
        const loginData = new FormData(e.target);
        console.log(loginData);
        const credentials = {
            email: loginData.get("email"),
            password: loginData.get("password"),
        };
        await loginService.loginLandlord(credentials).then((res) => {
            console.log(res.data);
            const userId = res.data["ownerId"];
            if (res.data) {      
                navigate("/landlord/dashboard");
            }
            else{                      
                setValidCreds(false);
            }
        })
            .catch((err) => {
                setValidCreds(false);
                console.log(err);
            });
    };

    return (
        <>
            <ThemeProvider theme={defaultTheme}>
                <Container component="main" maxWidth="xs">
                    <CssBaseline />
                    <Box
                        sx={{
                            marginTop: 8,
                            display: "flex",
                            flexDirection: "column",
                            alignItems: "center",
                        }}
                    >
                        <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
                            {/* <LockOutlinedIcon /> */}
                        </Avatar>
                        <Typography component="h1" variant="h5">
                            Landlord Login
                        </Typography>
                        <Box
                            component="form"
                            onSubmit={userLogin}
                            noValidate
                            sx={{ mt: 1 }}
                            className="text-start"
                        >
                            {!validCreds ? (
                                <Alert severity="error">Invalid Credentials</Alert>
                            ) : (
                                <></>
                            )}

                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                id="email"
                                label="Email Address"
                                name="email"
                                autoComplete="email"
                                autoFocus
                            />
                            <TextField
                                margin="normal"
                                required
                                fullWidth
                                name="password"
                                label="Password"
                                type="password"
                                id="password"
                                autoComplete="current-password"
                            />
                            <Button
                                type="submit"
                                fullWidth
                                variant="contained"
                                sx={{ mt: 3, mb: 2 }}
                            >
                                Sign In
                            </Button>
                            <Grid container>
                                <Grid item>
                                    <MuLink
                                        style={{ cursor: "pointer" }}
                                        variant="body2"
                                        onClick={() => {
                                            navigate("/register/landlord")
                                        }}
                                    >
                                        {"Don't have an account? Sign Up"}
                                    </MuLink>
                                </Grid>
                            </Grid>
                        </Box>
                    </Box>
                    {/* <Copyright sx={{ mt: 8, mb: 4 }} /> */}
                </Container>
            </ThemeProvider>
        </>
    )
}

export default LoginLandlord;
