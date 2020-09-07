import React from "react";
import Layout from "@theme/Layout";
import { DataTabs, PageLayout, DataProducts } from "../../components";
import { products } from "../../copy/data/products/water";

export default function FindData() {
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
