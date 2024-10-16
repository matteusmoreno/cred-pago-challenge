package br.com.matteusmoreno.credpago_challenge.response;

import br.com.matteusmoreno.credpago_challenge.entity.Product;

public record ProductDetailsResponse(
        String productId,
        String artist,
        String year,
        String album,
        Integer price,
        String store,
        String thumb,
        String date) {

    public ProductDetailsResponse(Product product) {
        this(
                product.getProductId(),
                product.getArtist(),
                product.getYear(),
                product.getAlbum(),
                product.getPrice(),
                product.getStore(),
                product.getThumb(),
                product.getDate()
        );
    }
}
