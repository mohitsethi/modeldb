#!/bin/sh

set -e

python fetch_model.py

cp requirements.txt requirements_local.txt

docker build -t model:02-mdb_versioned .
