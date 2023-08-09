import { Outlet } from "react-router-dom"

const Layout = () => {
    return (
        <main className="App" style={{ padding: 0}}>
            <Outlet />
        </main>
    )
}

export default Layout
