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

package com.nfsdb.ql.ops.count;

import com.nfsdb.ql.Record;
import com.nfsdb.ql.impl.map.MapValues;
import com.nfsdb.ql.ops.AbstractUnaryAggregator;
import com.nfsdb.ql.ops.Function;
import com.nfsdb.store.ColumnType;
import com.nfsdb.store.VariableColumn;

public final class CountStrAggregator extends AbstractUnaryAggregator {

    public static final CountStrAggregator FACTORY = new CountStrAggregator();

    private CountStrAggregator() {
        super(ColumnType.LONG);
    }

    @Override
    public void calculate(Record rec, MapValues values) {
        int len = value.getStrLen(rec);
        if (values.isNew()) {
            values.putLong(valueIndex, len == VariableColumn.NULL_LEN ? 0 : 1);
        } else if (len != VariableColumn.NULL_LEN) {
            values.putLong(valueIndex, values.getLong(valueIndex) + 1);
        }
    }

    @Override
    public Function newInstance() {
        return new CountStrAggregator();
    }
}
