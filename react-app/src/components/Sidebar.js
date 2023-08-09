import React from 'react'

const Sidebar = () => {
    const showTrade = () => {
        if(document.getElementById('secTable') && document.getElementById('traTable')){
            document.getElementById('secTable').style.display = 'none';
            document.getElementById('traTable').style.display = 'block';
        }
    }

    const showSecurities = () => {
        if(document.getElementById('secTable') && document.getElementById('traTable')){
            document.getElementById('secTable').style.display = 'block';
            document.getElementById('traTable').style.display = 'none';
        }
    }
  return (
    <>
    <div class="nav-left-sidebar sidebar-dark" style={{ left: '0px' }}>
            <div class="menu-list">
                <nav class="navbar navbar-expand-lg navbar-light">
                    <a class="d-xl-none d-lg-none" href="#">Dashboard</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav flex-column">
                            <li class="nav-divider">
                                Menu
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="#" data-toggle="collapse" aria-expanded="false" data-target="#submenu-1" aria-controls="submenu-1"><i class="fa fa-fw fa-user-circle"></i>Dashboard <span class="badge badge-success">6</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" onClick={showTrade} data-toggle="collapse" aria-expanded="false" data-target="#submenu-2" aria-controls="submenu-2"><i class="fa fa-fw fa-rocket"></i>Trade</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" onClick= {showSecurities} data-toggle="collapse" aria-expanded="false" data-target="#submenu-3" aria-controls="submenu-3"><i class="fas fa-fw fa-chart-pie"></i>Security</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </>
  )
}

export default Sidebar