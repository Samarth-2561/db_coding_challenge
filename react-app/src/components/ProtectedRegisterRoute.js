import React from 'react'
import { Route, Navigate } from 'react-router-dom';
import Unauthorized from './Unauthorized';

const ProtectedRegisterRoute = ({ component: Component, isAuthenticated }) => {
    return ( isAuthenticated ? <Component /> : <Unauthorized />);
}

export default ProtectedRegisterRoute