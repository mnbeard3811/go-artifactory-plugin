package com.tw.go.plugins.artifactory;

import com.tw.go.plugins.artifactory.model.GoArtifact;
import com.tw.go.plugins.artifactory.model.GoBuildDetails;
import com.tw.go.plugins.artifactory.model.GoBuildDetailsFactory;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.util.Arrays.asList;

public class GoBuildDetailsBuilder {
    private String buildName;
    private String buildNumber;
    private DateTime startedAt;
    private GoArtifact artifact;
    private String buildUrl;
    private Map<String, String> envVars = new HashMap<>();

    public GoBuildDetails build() {
        GoBuildDetails buildDetails = new GoBuildDetails(buildName, buildNumber, startedAt);
        buildDetails.artifacts(asList(artifact));
        buildDetails.url(buildUrl);
        buildDetails.environmentVariables(envVars);

        return buildDetails;
    }

    public GoBuildDetailsBuilder buildName(String name) {
        this.buildName = name;
        return this;
    }

    public GoBuildDetailsBuilder buildNumber(String number) {
        buildNumber = number;
        return this;
    }

    public GoBuildDetailsBuilder startedAt(DateTime startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public GoBuildDetailsBuilder artifact(GoArtifact artifact) {
        this.artifact = artifact;
        return this;
    }

    public GoBuildDetailsBuilder url(String buildUrl) {
        this.buildUrl = buildUrl;
        return this;
    }

    public GoBuildDetailsBuilder envVariable(String name, String value) {
        envVars.put(name, value);
        return this;
    }

    public GoBuildDetailsBuilder envVariables(Map<String, String> envVars) {
        this.envVars = envVars;
        return this;
    }
}
