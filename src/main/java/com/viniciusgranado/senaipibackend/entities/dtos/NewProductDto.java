package com.viniciusgranado.senaipibackend.entities.dtos;

import com.viniciusgranado.senaipibackend.entities.Category;

import java.util.List;
import java.util.Objects;

public class NewProductDto {
  private String name;
  private String description;
  private Double price;
  private String imgUrl;
  private boolean isFavorite;
  List<Category> categories;

  public NewProductDto() {
  }

  public NewProductDto(String name, String description, Double price, String imgUrl, boolean isFavorite, List<Category> categories) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.imgUrl = imgUrl;
    this.isFavorite = isFavorite;
    this.categories = categories;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public boolean isFavorite() {
    return isFavorite;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public void setFavorite(boolean favorite) {
    isFavorite = favorite;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NewProductDto that = (NewProductDto) o;
    return isFavorite == that.isFavorite && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(imgUrl, that.imgUrl) && Objects.equals(categories, that.categories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, price, imgUrl, isFavorite, categories);
  }
}
