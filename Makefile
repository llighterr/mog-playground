SBT = sbt
OPEN = open
PYTHON = python3
APP_NAME = mog-playground
PROD_RSC = docs
TEST_ASS = assets
PROD_ASS = ${PROD_RSC}/assets
DEV_PORT = 8000
COPY_PROD = cp -f target/scala-2.12/${APP_NAME}-opt.js ${PROD_ASS}/js/ && cp -rf ${TEST_ASS}/* ${PROD_ASS}/
REMOVE_MAPPING = sed -i '' -e '/\/\/\# sourceMappingURL.*/d' ${PROD_ASS}/js/${APP_NAME}-opt.js
UGLIFY_CSS = rm -f ${PROD_ASS}/css/* && uglifycss ${TEST_ASS}/css/[bmps]* > ${PROD_ASS}/css/pg.min.css && uglifycss ${TEST_ASS}/css/notesview.css > ${PROD_ASS}/css/notesview.css

build: sync_frontend_assets
	${SBT} fastOptJS

test:
	${SBT} test

console:
	${SBT} test:console

clean:
	rm -rf ~/.sbt/1.0/staging/*/mog-*
	${SBT} clean

local:
	${OPEN} http://localhost:${DEV_PORT}/index-dev-debug.html?debug=true

local-prod:
	${OPEN} http://localhost:${DEV_PORT}/

server:
	${PYTHON} -m 'http.server' ${DEV_PORT}

server-prod:
	cd docs && ${PYTHON} -m 'http.server' ${DEV_PORT}

sync_frontend_assets:
	cp -rf ../mog-frontend/assets .
	rm -f assets/js/bootstrap.js

publish: sync_frontend_assets clean test
	sbt fullOptJS
	${COPY_PROD}
	${REMOVE_MAPPING}
	${UGLIFY_CSS}

publish-commit: publish
	git add .
	git commit -m Publish
	git push

publish-assets:
	${COPY_PROD}
	${REMOVE_MAPPING}
	${UGLIFY_CSS}

copy-prod:
	${COPY_PROD}

uglify-css:
	${UGLIFY_CSS}

remove-mapping:
	${REMOVE_MAPPING}

merge:
	git checkout master
	git pull
	git checkout develop
	git merge master
	git push

.PHONY: build test console clean local local-prod server server-prod publish publish-commit publish-assets merge

