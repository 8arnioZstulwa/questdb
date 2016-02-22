/*******************************************************************************
 *  _  _ ___ ___     _ _
 * | \| | __/ __| __| | |__
 * | .` | _|\__ \/ _` | '_ \
 * |_|\_|_| |___/\__,_|_.__/
 *
 * Copyright (c) 2014-2016. The NFSdb project and its contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.nfsdb.ql.ops.gte;

import com.nfsdb.ql.Record;
import com.nfsdb.ql.ops.AbstractBinaryOperator;
import com.nfsdb.ql.ops.Function;
import com.nfsdb.store.ColumnType;

public class LongGreaterOrEqualOperator extends AbstractBinaryOperator {

    public final static LongGreaterOrEqualOperator FACTORY = new LongGreaterOrEqualOperator();

    private LongGreaterOrEqualOperator() {
        super(ColumnType.BOOLEAN);
    }

    @Override
    public boolean getBool(Record rec) {
        long r = rhs.getLong(rec);
        return lhs.getLong(rec) >= r && r > Long.MIN_VALUE;
    }

    @Override
    public Function newInstance() {
        return new LongGreaterOrEqualOperator();
    }
}
