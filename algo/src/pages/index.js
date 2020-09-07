import React from "react";
import { Redirect } from "react-router-dom";
import Layout from "@theme/Layout";
import useDocusaurusContext from "@docusaurus/useDocusaurusContext";
import styles from "./styles.module.css";
import { CustomHead } from "../components/CustomHead";
import { Landing } from "../components/Landing";
import { Logos } from "../components/Logos";
import { ValueProps } from "../components/ValueProps";
import { BuyData } from "../components/BuyData";
import { SellData } from "../components/SellData";
import { MailingListSubscribeSection } from "../components/MailingListSubscribe";
import { HowWeThinkAboutData } from "../components/HowWeThinkAboutData";

function Home() {
    const context = useDocusaurusContext();
    const { siteConfig = {} } = context;
    return (
        <React.Fragment>
            <CustomHead />
            <Layout
                title={`Amphora Data | ${siteConfig.title}`}
                description="Buy or sell data in real time."
            >
                <Landing siteConfig={siteConfig} styles={styles} />

                <main>
                    <SellData />
                    <hr />
                    <BuyData />
                    <ValueProps styles={styles} />
                    <MailingListSubscribeSection styles={styles} />
                    <Logos />
                    <HowWeThinkAboutData />
                </main>
            </Layout>
        </React.Fragment>
    );
}

// export default Home;
// this overrides the default behaviour, and redirects to the docs page.
function CustomRedirect() {
    return <Redirect to="/docs/contents" />;
}
export default Home;
