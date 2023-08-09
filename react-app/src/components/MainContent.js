import React, { useState } from "react";
import Securities from "./Securities";
import Trades from "./Trades";

const MainContent = ({ textDB }) => {
  return (
    <>
      <div class="dashboard-wrapper">
        <div class="dashboard-ecommerce">
          <div class="container-fluid dashboard-content ">
            <div class="row">
              <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="page-header">
                  <h2 class="pageheader-title">{textDB} Dashboard</h2>
                  <p class="pageheader-text">
                    Nulla euismod urna eros, sit amet scelerisque torton lectus
                    vel mauris facilisis faucibus at enim quis massa lobortis
                    rutrum.
                  </p>
                </div>
              </div>
            </div>
            <div class="ecommerce-widget">
              <div class="row">
                <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                  <div class="card">
                    <div class="card-body">
                      <h5 class="text-muted">Total Bonds</h5>
                      <div class="metric-value d-inline-block">
                        <h1 class="mb-1">25</h1>
                      </div>
                    </div>
                    <div id="sparkline-revenue"></div>
                  </div>
                </div>
                <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                  <div class="card">
                    <div class="card-body">
                      <h5 class="text-muted">Total Securities</h5>
                      <div class="metric-value d-inline-block">
                        <h1 class="mb-1">14</h1>
                      </div>
                    </div>
                    <div id="sparkline-revenue2"></div>
                  </div>
                </div>
                <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                  <div class="card">
                    <div class="card-body">
                      <h5 class="text-muted">No of Buyers</h5>
                      <div class="metric-value d-inline-block">
                        <h1 class="mb-1">5</h1>
                      </div>
                    </div>
                    <div id="sparkline-revenue3"></div>
                  </div>
                </div>
                <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
                  <div class="card">
                    <div class="card-body">
                      <h5 class="text-muted">No of Sellers</h5>
                      <div class="metric-value d-inline-block">
                        <h1 class="mb-1">7</h1>
                      </div>
                    </div>
                    <div id="sparkline-revenue4"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="showTable">
          <Securities />
          <Trades />
        </div>
        <br />
        <br />
        <div class="footer">
          <div class="container-fluid">
            <div class="row">
              <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                Copyright © 2023 Concept. All rights reserved. Dashboard by{" "}
                <a href="https://colorlib.com/wp/">DB Grads Team 29</a>.
              </div>
              <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
                <div class="text-md-right footer-links d-none d-sm-block">
                  <a href="javascript: void(0);">About</a>
                  <a href="javascript: void(0);">Support</a>
                  <a href="javascript: void(0);">Contact Us</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default MainContent;
