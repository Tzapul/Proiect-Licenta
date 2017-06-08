```
CompilationJobResult
{
	error: boolean,
	result: string,
	internalError: boolean
}

TestJobResult
{
	error: boolean,
	result: string,
	totalTests: int,
	passedTests: int,
	internalError: boolean
}

PlagiarismJobResult
{
	error: boolean,
	result: string,
	detected: boolean,
	internalError: boolean
}

CompilationJob
{
	path:string, /cnp_prof/nume_topic/nume_task/cnp_student
	language:string, litere mari
	type: string litere mari
}

TestJob{
	path:string,
	language:string, litere mari
	type: string                       //intre fiecare test exista new line
}

PlagiarismJob{
	paths: [
		p1,p2
	],
	type:string
}
```
