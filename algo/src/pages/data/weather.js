import React from "react";
import Layout from "@theme/Layout";
import Link from "@docusaurus/Link";
import classnames from "classnames";
import useBaseUrl from "@docusaurus/useBaseUrl";
import styles from "../styles.module.css";
import { DataTabs, PageLayout, DataProducts } from "../../components";
import { products } from "../../copy/data/products/weather";

export default function Page() {
    return (
        <Layout title="Data Catalogue">
            <PageLayout
                tabs={DataTabs}
                heading="Data Products"
                subheading="Get the insights you need in 30 seconds"
            >
                <DataProducts products={products} />
            </PageLayout>
        </Layout>
    );
}
