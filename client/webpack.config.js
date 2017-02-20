const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const ExtractTextPluginConfig = new ExtractTextPlugin('stylesheets/[name].css', { allChunks: true });
const HTMLWebpackPluginConfig = new HtmlWebpackPlugin({
    template: __dirname + '/src/index.html',
    filename: 'index.html',
    inject: 'body'
});
module.exports = {
    entry: {
        index_bundle: './src/index.js'
    },
    module: {
        loaders: [
            {test: /\.js$/, exclude: /node_modules/, loader: "babel-loader"},
            {test: /\.scss$/,loader: ExtractTextPlugin.extract('css!sass')}
        ]
    },
    output: {
        filename: "[name].js",
        path: '../server/src/main/resources/static'
    },
    plugins: [HTMLWebpackPluginConfig, ExtractTextPluginConfig]
};