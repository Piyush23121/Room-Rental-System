import React from 'react'
import loginService from '../../../Service/login.service';
import { Link as MuLink } from "@mui/material";
import Typography from "@mui/material/Typography";
import { Alert, Box, Button, Checkbox, Container, CssBaseline, FormControlLabel, Grid, TextField, ThemeProvider, createTheme } from '@mui/material';
import { useNavigate } from 'react-router-dom';
function LoginTenant() {
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
        await loginService.loginTenant(credentials).then((res) => {
            console.log(res.data);
            const userId = res.data["tenantId"];
            if(res.data){
              navigate("/");
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
            <Typography component="h1" variant="h5">
              User Login
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
                    //   history.replace("/register");
                    navigate("/register/tenant")
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

export default LoginTenant;
