import * as React from "react";
import Layout from "@theme/Layout";
import { DataTabs, PageLayout, DataProducts } from "../../components";
import { products } from "../../copy/data/products/vegetation";

export default function Vegetation() {
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
