import React from "react";
import Layout from "@theme/Layout";
import classnames from "classnames";
import styles from "./styles.module.css";

function values() {
    return (
        <Layout title="Mission and Values">
            <div className="container container--fluid">
                <div
                    className="row p-4"
                    className={classnames("hero", styles.heroBanner)}
                >
                    <h2
                        className="font_large text--white"
                        style={{
                            paddingLeft: "240px",
                            paddingRight: "240px",
                            paddingTop: "120px",
                            paddingBottom: "60px",
                        }}
                    >
                        We will transform the way knowledge is shared by
                        innovative teams and researchers
                    </h2>
                </div>

                <div
                    className={classnames("row", styles.justifyContentCenter)}
                    style={{ paddingTop: "60px", paddingBottom: "120px" }}
                >
                    <div className="col">
                        <h3 className="font_large text--center">
                            We operate by 3 values that will help us achieve our
                            mission
                        </h3>
                        <div style={{ paddingTop: "30px" }}></div>
                        <p className="font_medium_bold text--center">
                            We are responsible custodians of information
                        </p>
                        <p className="font_medium_bold text--center">
                            We empower our customers to share their knowledge
                        </p>
                        <p className="font_medium_bold text--center">
                            We work together to succeed as a team
                        </p>
                    </div>
                </div>
            </div>
        </Layout>
    );
}

export default values;
