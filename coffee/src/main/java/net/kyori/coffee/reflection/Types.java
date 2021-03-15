/*
 * This file is part of coffee, licensed under the MIT License.
 *
 * Copyright (c) 2020-2021 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.coffee.reflection;

import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * A collection of utilities for working with types.
 *
 * @since 1.0.0
 */
public final class Types {
  private Types() {
  }

  /**
   * Gets a list of all ancestors of {@code type}.
   *
   * @param type the source type
   * @param <T> the class type
   * @return a collection of ancestors
   * @since 1.0.0
   */
  @SuppressWarnings("unchecked")
  public static <T> @NonNull List<Class<? super T>> ancestors(final @NonNull Class<T> type) {
    final List<Class<? super T>> types = new ArrayList<>();
    types.add(type);
    for(int i = 0; i < types.size(); i++) {
      final Class<?> next = types.get(i);
      final Class<?> superclass = next.getSuperclass();
      if(superclass != null) {
        types.add((Class<? super T>) superclass);
      }
      final Class<?>[] interfaces = next.getInterfaces();
      for(final Class<?> iface : interfaces) {
        // we have a list because we want to preserve order, but we don't want duplicates
        if(!types.contains(iface)) {
          types.add((Class<? super T>) iface);
        }
      }
    }
    return types;
  }
}
