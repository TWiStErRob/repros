package pack;

import org.ajoberstar.grgit.Grgit;
import org.eclipse.jgit.revwalk.RevWalk;

class GITPlugin {

	@SuppressWarnings("deprecation")
	Grgit open() {
		return Grgit.open(new java.io.File("."));
	}

	int revisionNumber() throws Exception {
		Grgit git = open();
		org.eclipse.jgit.lib.Repository repository = git.getRepository().getJgit().getRepository();
		RevWalk walk = new RevWalk(repository);
		walk.setRetainBody(false);
		walk.markStart(walk.parseCommit(repository.resolve("HEAD")));
		java.util.Iterator<?> it = walk.iterator();
		int count = 0;
		while (it.hasNext()) {
			it.next();
			count++;
		}
		return count;
	}
}
