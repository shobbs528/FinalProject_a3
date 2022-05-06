package tage.networking.server;

import tage.ai.behaviortrees.BTAction;
import tage.ai.behaviortrees.BTStatus;

public class GetBig extends BTAction
{
	NPC npc;
  
	public GetBig(NPC n)
	{	npc = n;
	}

	protected BTStatus update(float elapsedTime)
	{	npc.getBig();
		return BTStatus.BH_SUCCESS;
	}
}
