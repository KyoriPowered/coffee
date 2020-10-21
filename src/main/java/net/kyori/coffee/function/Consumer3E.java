/*
 * This file is part of coffee, licensed under the MIT License.
 *
 * Copyright (c) 2020 KyoriPowered
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
package net.kyori.coffee.function;

/**
 * An operation that accepts three input arguments and returns no result, potentially throwing an exception.
 *
 * @param <T1> the first argument type
 * @param <T2> the second argument type
 * @param <T3> the third argument type
 * @param <E> the potential exception type
 * @since 1.0.0
 */
@FunctionalInterface
public interface Consumer3E<T1, T2, T3, E extends Throwable> {
  /**
   * Performs this operation on the given arguments.
   *
   * @param t1 the first argument
   * @param t2 the second argument
   * @param t3 the third argument
   * @throws E potential exception
   * @since 1.0.0
   */
  void accept(final T1 t1, final T2 t2, final T3 t3) throws E;
}
