import { createTheme } from "@mui/material";
import { blue } from "@mui/material/colors";
import { Box, ThemeProvider } from "@mui/system";
import React from "react";
import { Provider } from "react-redux";
import { store } from "../redux/app/store";

const theme = createTheme({
  palette: {
    primary: {
      main: blue[500],
    },
  },
  components: {
    MuiChip: {
      styleOverrides: {
        root: {
          borderRadius: "1rem",
        },
      },
    },
  },
});
export default function App():JSX.Element {
  return (
    <Provider store={store}>

      <ThemeProvider theme={theme}>
        <Box display="flex" minWidth="100vh" justifyContent="center">
          <h2>Initial School Enrollment Application</h2>
        </Box>
      </ThemeProvider>
    </Provider>
  );
}
