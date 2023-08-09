import { Link } from "react-router-dom"

const Manager = () => {
    return (
        <section>
            <h1>Manager Page</h1>
            <br />
            <p>You have been assigned an Manager role.</p>
            <div className="flexGrow">
                <Link to="/">Home</Link>
            </div>
        </section>
    )
}

export default Manager
