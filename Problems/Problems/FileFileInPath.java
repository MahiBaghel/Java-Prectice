package Problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FindFileInPath {

    protected static Collection<Path> find(String searchDirectory, PathMatcher matcher) throws IOException {
        try (Stream<Path> files = Files.walk(Paths.get(searchDirectory))) {
            return files.filter(matcher::matches).collect(Collectors.toList());

        }
    }

    public static void main(String[] args) {

    }
}