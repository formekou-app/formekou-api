#!/bin/bash

if [ "$#" -ne 6 ]; then
    echo " [ LOG ]: ERROR, there are some missing value"
    exit 1
fi

FDB_USER="$1"
export PGPASSWORD="$2"
FDB_HOST="$3"
FDB_PORT="$4"
FDB_NAME="$5"
FDB_MIGRATION_PATH="$6"

echo " [ LOG ]: Create table_version if not exist"
psql -U "$FDB_USER" -h "$FDB_HOST" -p "$FDB_PORT" -d "$FDB_NAME" -c "CREATE TABLE IF NOT EXISTS schema_version (id serial PRIMARY KEY, version VARCHAR(255));"

current_version=$(psql -U "$FDB_USER" -p "$FDB_PORT" -h "$FDB_HOST" -d "$FDB_NAME" -t -c "SELECT COALESCE(MAX(id), 0) FROM schema_version;" | tr -d '[:space:]')
if [ -z "$current_version" ]; then
    current_version="V0"
else
    current_version="V$current_version"
fi
echo "[ LOG ]: CURRENT_VERSION => $current_version"

latest_version=$(ls "$FDB_MIGRATION_PATH" | grep -Eo 'V[0-9]+' | sort -n | tail -n 1)
echo "[ LOG ]: LAST_VERSION => $latest_version"

for migration_file in $(ls "$FDB_MIGRATION_PATH" | grep -Eo "V[0-9]+.*\.sql" | sort -n); do
    version=$(echo "$migration_file" | sed 's/\(V[0-9]\+\).*/\1/')
    
    if [ "$version" = "$latest_version" ]; then
        full_path="$FDB_MIGRATION_PATH/$migration_file"
        
        echo "[ LOG ]: Executing migration script: $migration_file"
        psql -U "$FDB_USER" -p "$FDB_PORT" -h "$FDB_HOST" -d "$FDB_NAME" -f "$full_path"
    fi
done
