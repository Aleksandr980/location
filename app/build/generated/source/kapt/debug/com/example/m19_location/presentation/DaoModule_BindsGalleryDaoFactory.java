// Generated by Dagger (https://dagger.dev).
package com.example.m19_location.presentation;

import com.example.m19_location.data.GalleryDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class DaoModule_BindsGalleryDaoFactory implements Factory<GalleryDao> {
  private final DaoModule module;

  public DaoModule_BindsGalleryDaoFactory(DaoModule module) {
    this.module = module;
  }

  @Override
  public GalleryDao get() {
    return bindsGalleryDao(module);
  }

  public static DaoModule_BindsGalleryDaoFactory create(DaoModule module) {
    return new DaoModule_BindsGalleryDaoFactory(module);
  }

  public static GalleryDao bindsGalleryDao(DaoModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.bindsGalleryDao());
  }
}
