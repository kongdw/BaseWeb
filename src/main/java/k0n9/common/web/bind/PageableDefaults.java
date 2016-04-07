/*
 * Copyright 2002-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package k0n9.common.web.bind;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>默认的分页数据，先从参数找，参数找不到从方法上找</p>
 *
 * @author David Kong
 */
@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageableDefaults {


    /**
     * The default-size the injected {@link k0n9.common.entity.search.domain.Pageable} should get if no corresponding
     * parameter defined in request (default is 10).
     */
    int value() default 10;

    /**
     * The default-pagenumber the injected {@link k0n9.common.entity.search.domain.Pageable} should get if no corresponding
     * parameter defined in request (default is 0).
     */
    int pageNumber() default 0;

    /**
     * 默认的排序 格式为{"a=desc, a.b=desc"}
     */
    String[] sort() default {};

}
