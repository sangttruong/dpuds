import React from "react";
import Layout from "@theme/Layout";
import Link from "@docusaurus/Link";
import classnames from "classnames";
import useBaseUrl from "@docusaurus/useBaseUrl";
import styles from "./styles.module.css";

function leadership_team() {
    return (
        <Layout title="Leadership Team">
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
                        We Are An Experienced Team With Distinctive Expertise In
                        Software Engineering, Data Governance, People
                        Leadership, Operations, Agriculture, Data Science And
                        Strategy.
                    </h2>
                </div>

                <div
                    className={classnames("row", styles.justifyContentCenter)}
                    style={{ paddingTop: "60px" }}
                >
                    <div
                        className="col col--4"
                        style={{ paddingLeft: "360px" }}
                    >
                        <img
                            src="img/IMG_1205.jpg"
                            alt="leadership team"
                            width="200"
                        />
                    </div>
                    <div className="col">
                        <Link
                            className="font_large"
                            to={useBaseUrl(
                                "https://linkedin.com/isaac-donnelly"
                            )}
                        >
                            Isaac Donnelly
                        </Link>
                        <h3 className="font_large">
                            Managing director and co-founder
                        </h3>
                        <p className="font_medium mb-4">
                            Isaac leads the direction and operations of Amphora
                            Data as well as ensuring customers get the right
                            outcomes.
                        </p>
                        <p className="font_medium mb-4">
                            He was previously an Engagement Manager at McKinsey
                            & Company specialising in data, analytics and
                            technology strategy and transformation.
                        </p>
                        <p className="font_medium mb-4">
                            Isaac has a Ph.D. in Applied Mathematics from UNSW
                            and was the recipient of the prestigious Fulbright
                            award in 2015.
                        </p>
                    </div>
                </div>
                <div
                    className={classnames("row", styles.justifyContentCenter)}
                    style={{ paddingTop: "60px", paddingBottom: "120px" }}
                >
                    <div
                        className="col col--4"
                        style={{ paddingLeft: "360px" }}
                    >
                        <img
                            src="img/IMG_1209.jpg"
                            alt="leadership team"
                            width="200"
                        />
                    </div>
                    <div className="col">
                        <Link
                            className="font_large"
                            to={useBaseUrl(
                                "https://linkedin.com/rian-finnegan"
                            )}
                        >
                            Rian Finnegan
                        </Link>
                        <h3 className="font_large">
                            Chief technology officer and co-founder
                        </h3>
                        <p className="font_medium mb-4">
                            Rian leads the technology and product development at
                            Amphora Data and also looks after our people.
                        </p>
                        <p className="font_medium mb-4">
                            Prior to starting Amphora Data, he was a Software
                            Engineer at Microsoft focused on building products
                            on Azure for external clients.
                        </p>
                        <p className="font_medium mb-4">
                            He holds a double Bachelor of Electrical Engineering
                            & Arts from UNSW.
                        </p>
                    </div>
                </div>
            </div>
        </Layout>
    );
}

export default leadership_team;
