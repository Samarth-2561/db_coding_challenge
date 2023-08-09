import React from 'react';
import avatar1 from '../images/avatar-1.jpg';
import avatar2 from '../images/avatar-2.jpg';
import avatar3 from '../images/avatar-3.jpg';
import avatar4 from '../images/avatar-4.jpg';
import avatar5 from '../images/avatar-5.jpg';
import github from '../images/github.png';
import slack from '../images/slack.png';
import mail_chimp from '../images/mail_chimp.png';
import bitbucket from '../images/bitbucket.png';
import dropbox from '../images/dropbox.png';
import dribbble from '../images/dribbble.png';
import dbLogo from '../images/dbLogo.png';
import Cookies from 'js-cookie';
import { useNavigate } from "react-router-dom";
import { useContext } from "react";
import AuthContext from "../context/AuthProvider";
import Avatar from 'react-avatar';

const Header = () => {
    const { setAuth } = useContext(AuthContext);
    const navigate = useNavigate();
    const logout = async () => {
        console.log("heelo");
      Cookies.remove("role");
      Cookies.remove("username");
      Cookies.remove("accessToken");
      Cookies.remove("email");
      setAuth({});
      navigate("/login");
    };
  return (
    <>
    <div class="dashboard-header">
        <nav class="navbar navbar-expand-lg bg-white fixed-top">
            <a class="navbar-brand" href="index.html"><img src={dbLogo} style={{ maxWidth: '154px'}} alt='dbLogo'/></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto navbar-right-top">
                    <li class="nav-item">
                        <div id="custom-search" class="top-search-bar">
                            <input class="form-control" type="text" placeholder="Search.." />
                        </div>
                    </li>
                    <li class="nav-item dropdown notification">
                        <a class="nav-link nav-icons" href="#" id="navbarDropdownMenuLink1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-fw fa-bell"></i> <span class="indicator"></span></a>
                        <ul class="dropdown-menu dropdown-menu-right notification-dropdown">
                            <li>
                                <div class="notification-title"> Notification</div>
                                <div class="notification-list">
                                    <div class="list-group">
                                        <a href="#" class="list-group-item list-group-item-action active">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img src={avatar2} alt="" class="user-avatar-md rounded-circle" /></div>
                                                <div class="notification-list-user-block"><span class="notification-list-user-name">NYTRADE</span>🔒 Security Alert: Important Account Update
                                                    <div class="notification-date">2 min ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item list-group-item-action">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img src={avatar3} alt="" class="user-avatar-md rounded-circle" /></div>
                                                <div class="notification-list-user-block"><span class="notification-list-user-name">NASDAQ </span>📈 Trade Confirmation: Bond Transaction Successful
                                                    <div class="notification-date">2 days ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item list-group-item-action">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img src={avatar4} alt="" class="user-avatar-md rounded-circle" /></div>
                                                <div class="notification-list-user-block"><span class="notification-list-user-name">BSE/NSE</span> 🚨 Urgent: Security Tips for Bond Trading
                                                    <div class="notification-date">2 min ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item list-group-item-action">
                                            <div class="notification-info">
                                                <div class="notification-list-user-img"><img src={avatar5} alt="" class="user-avatar-md rounded-circle" /></div>
                                                <div class="notification-list-user-block"><span class="notification-list-user-name">BULLRUN</span>🔐 Account Security Check: One-Time Verification
                                                    <div class="notification-date">2 min ago</div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="list-footer"> <a href="#">View all notifications</a></div>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown connection">
                        <a class="nav-link" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fas fa-fw fa-th"></i> </a>
                        <ul class="dropdown-menu dropdown-menu-right connection-dropdown">
                            <li class="connection-list">
                                <div class="row">
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src={github} alt="" /> <span>Github</span></a>
                                    </div>
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src={dribbble} alt=""  /> <span>Dribbble</span></a>
                                    </div>
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src={dropbox} alt=""  /> <span>Dropbox</span></a>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src={bitbucket} alt="" /> <span>Bitbucket</span></a>
                                    </div>
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src={mail_chimp} alt=""  /><span>Mail chimp</span></a>
                                    </div>
                                    <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12 ">
                                        <a href="#" class="connection-item"><img src={slack} alt=""  /> <span>Slack</span></a>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="conntection-footer"><a href="#">More</a></div>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown nav-user">
                        <a class="nav-link nav-user-img" href="#" id="navbarDropdownMenuLink2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><Avatar  name={Cookies.get('username')} size='25' class="user-avatar-md rounded-circle" round textSizeRatio={2} /></a>
                        <div class="dropdown-menu dropdown-menu-right nav-user-dropdown" aria-labelledby="navbarDropdownMenuLink2">
                            <div class="nav-user-info">
                                <h5 class="mb-0 text-white nav-user-name">{Cookies.get('username')} </h5>
                            </div>
                            <a class="dropdown-item" href="#"><i class="fas fa-user mr-2"></i>Account</a>
                            <a class="dropdown-item" href='/register'><i class="fas fa-cog mr-2"></i>Register a User</a>
                            <button class="dropdown-item" onClick = {logout}><i class="fas fa-power-off mr-2"></i>Logout</button>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    </>
  )
}

export default Header