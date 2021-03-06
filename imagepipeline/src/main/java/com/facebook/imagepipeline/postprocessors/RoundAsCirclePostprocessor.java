/*
 * Copyright (c) 2017-present, Facebook, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

/** Postprocessor that rounds a given image as a circle. */
public class RoundAsCirclePostprocessor extends BasePostprocessor {

  private @Nullable CacheKey mCacheKey;

  @Override
  public void process(Bitmap bitmap) {
    NativeRoundingFilter.toCircle(bitmap);
  }

  @Nullable
  @Override
  public CacheKey getPostprocessorCacheKey() {
    if (mCacheKey == null) {
      mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
    }
    return mCacheKey;
  }
}
